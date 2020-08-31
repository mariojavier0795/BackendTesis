package com.example.tesis.backend.controller

import com.example.tesis.backend.entity.Imagenes
import com.example.tesis.backend.entity.TypeDocuments
import com.example.tesis.backend.entity.TypeDocumentsDetail
import com.example.tesis.backend.repository.ImagenesRepository
import com.example.tesis.backend.repository.TypeDocumentsDetailRepository
import com.example.tesis.backend.repository.TypeDocumentsRepository
import com.example.tesis.backend.structure.JsonStructureTemp
import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.nio.file.Files
import java.nio.file.Paths
import java.text.ParseException
import java.util.*


@CrossOrigin("*")
@RequestMapping("/ocr")
@RestController
class OCRController(private val typeDocumentsRepository: TypeDocumentsRepository,
                    private val typeDocumentsDetailRepository: TypeDocumentsDetailRepository,
                    private val imagenesRepository: ImagenesRepository) {

    @GetMapping("/getTypeDocuments")
    fun getTypeDocuments(): ResponseEntity<List<TypeDocuments?>?> {
        return ResponseEntity.ok(typeDocumentsRepository.findAll())
    }

    @PostMapping("saveImage")
    fun saveImage(@RequestBody imagenes: Imagenes?): ResponseEntity<Boolean>{
        var result = false
        if(imagenes != null) {
            imagenesRepository.save(imagenes)
            result = true
        }
        return ResponseEntity.ok(result)
    }

    @GetMapping("getDocuments")
    fun getDocuments():ResponseEntity<List<Imagenes>>{
        val result = imagenesRepository.findAll()
        return ResponseEntity.ok(result)
    }

    @PostMapping("getDocumentsID")
    fun getDocumentsID(@RequestBody imagen: Imagenes): ResponseEntity<Imagenes?>{
        val result = imagenesRepository.getImagen(imagen.cimagen)
        return ResponseEntity.ok(result!!)
    }

    @PostMapping("getTypeDocumentsDetail")
    fun getTypeDocumentsDetail(@RequestBody typeDocuments: TypeDocuments?): ResponseEntity<List<TypeDocumentsDetail?>?> {
        return ResponseEntity.ok(typeDocumentsDetailRepository.getTypeDocumentsDetail(typeDocuments)!!)
    }

    @PostMapping("saveTypeDocumentsDetail")
    fun saveTypeDocumentsDetail(@RequestBody listTypeDocumentsDetail: List<TypeDocumentsDetail?>?): ResponseEntity<Boolean> {
        listTypeDocumentsDetail?.forEach {
            typeDocumentsDetailRepository.save(it!!)
        }
        return ResponseEntity.ok(true)
    }

    @PostMapping("reconocerOCR")
    fun reconocerOCR(@RequestBody jsonStructureTemp: JsonStructureTemp?): ResponseEntity<JSONObject> {
        var arrayOCR = JSONArray()
        var jsonOCR = JSONObject()
        var region = ""
        jsonStructureTemp?.listTypeDocumentsDetail?.forEach {
            region += formatRegionOCR(it?.valueParametered) + ","
        }
        region = region.substring(0, region.length-1)
        val result = apiRestOCR(region, jsonStructureTemp?.imagen)
        result?.forEachIndexed { index, element ->
            val json = JSONObject()
            if (jsonStructureTemp != null) {
                json.put("nombre", jsonStructureTemp.listTypeDocumentsDetail?.get(index)?.nameColumn)
                json.put("valor", element)
            }
            arrayOCR.add(json)
        }
        jsonOCR.put("OCR", arrayOCR)
        return ResponseEntity.ok(jsonOCR)
    }

    fun formatRegionOCR(regionRequest: String?): String? {
        var xRegion = ""
        var yRegion = ""
        val listRegion: List<String> = regionRequest?.split("-")!!.map { it.trim() }
        if(listRegion[0].lastIndexOf(".") != -1) {
            xRegion = listRegion[0].substring(0, listRegion[0].lastIndexOf("."))
        } else {
            xRegion = listRegion[0]
        }
        if(listRegion[1].lastIndexOf(".") != -1) {
            yRegion = listRegion[1].substring(0, listRegion[1].lastIndexOf("."))
        } else {
            yRegion = listRegion[1]
        }
        return yRegion + ":" + xRegion + ":" + listRegion[3] + ":" + listRegion[2]
    }

    @PostMapping("drawOCR")
    fun drawOCR(@RequestBody imagen: String?): JSONArray? {
        var jsonResult = JSONArray()
        val user_name = "mariojavier0795"
        val license_code = "2394E697-4C21-46C9-8951-36D1D7BA0C4C"
        val ocrURL = "http://www.ocrwebservice.com/restservices/processDocument?gettext=true&getwords=true"
        val filePath = "/Users/mariojavier0795/Documents/Repositorios/rest-gestor-documental/ComprobantePagoIESS.jpg";
        //val decoder = Base64.getDecoder().decode(imagen)
        val fileContent = Files.readAllBytes(Paths.get(filePath))
        val url = URL(ocrURL)
        val connection = url.openConnection() as HttpURLConnection
        connection.doOutput = true
        connection.doInput = true
        connection.requestMethod = "POST"
        connection.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((user_name + ":" + license_code).toByteArray()))
        connection.setRequestProperty("Content-Type", "application/json")
        connection.setRequestProperty("Content-Length", fileContent.size.toString())
        val stream = connection.outputStream
        //stream.write(decoder)
        stream.write(fileContent)
        stream.close()
        val httpCode = connection.getResponseCode();
        println("HTTP Response code: " + httpCode)
        if (httpCode == HttpURLConnection.HTTP_OK) {
            val jsonResponse = GetResponseToString(connection.inputStream)
            jsonResult = PrintOCRResponse(jsonResponse!!)
        } else if (httpCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
            println("OCR Error Message: Unauthorizied request")
        } else {
            println("Error Message: ")
        }

        connection.disconnect()
        return jsonResult
    }

    fun apiRestOCR(region: String?, imagen: String?): JSONArray? {
        var jsonResult = JSONArray()
        val user_name = "mariojavier0795"
        val license_code = "2394E697-4C21-46C9-8951-36D1D7BA0C4C"
        //val ocrURL = "http://www.ocrwebservice.com/restservices/processDocument?gettext=true&getwords=true&zone=83:392:19:129";
        val ocrURL = "http://www.ocrwebservice.com/restservices/processDocument?gettext=true&getwords=true&zone=" + region
        val filePath = "/Users/mariojavier0795/Documents/Repositorios/rest-gestor-documental/ComprobantePagoIESS.pdf";
        val decoder = Base64.getDecoder().decode(imagen)
        val fileContent = Files.readAllBytes(Paths.get(filePath))
        val url = URL(ocrURL)
        val connection = url.openConnection() as HttpURLConnection
        connection.doOutput = true
        connection.doInput = true
        connection.requestMethod = "POST"
        connection.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((user_name + ":" + license_code).toByteArray()))
        connection.setRequestProperty("Content-Type", "application/json")
        connection.setRequestProperty("Content-Length", decoder.size.toString())
        val stream = connection.outputStream
        stream.write(decoder)
        //stream.write(fileContent)
        stream.close()
        val httpCode = connection.getResponseCode();
        println("HTTP Response code: " + httpCode)
        if (httpCode == HttpURLConnection.HTTP_OK) {
            val jsonResponse = GetResponseToString(connection.inputStream)
            jsonResult = PrintOCRResponse(jsonResponse!!)
        } else if (httpCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
            println("OCR Error Message: Unauthorizied request")
        } else {
            println("Error Message: ")
        }

        connection.disconnect()
        return jsonResult
    }

    @Throws(IOException::class)
    fun GetResponseToString(inputStream: InputStream): String? {
        val responseStream = InputStreamReader(inputStream)
        val br = BufferedReader(responseStream)
        val strBuff = StringBuffer()
        var s: String?
        while (br.readLine().also { s = it } != null) {
            strBuff.append(s)
        }
        return strBuff.toString()
    }

    @Throws(ParseException::class, IOException::class)
    fun PrintOCRResponse(jsonResponse: String): JSONArray {
        // Parse JSON data
        val parser = JSONParser()
        val jsonObj = parser.parse(jsonResponse) as JSONObject
        println("AvailablePages: " + jsonObj["AvailablePages"].toString())
        // get an array from the JSON object
        //val text: JSONArray = jsonObj["OCRText"] as JSONArray
        val text: JSONArray = jsonObj["OCRWords"] as JSONArray
        return text
    }
}