package com.example.tesis.backend.controller

import org.json.JSONObject
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.*
import java.net.URL
import java.net.URLEncoder
import java.util.*
import javax.net.ssl.HttpsURLConnection


@CrossOrigin("*")
@RequestMapping("/ocr")
@RestController
class OCRController {

    @PostMapping("/prueba")
    fun pruebaOCR(@RequestBody name: String?): ResponseEntity<JSONObject> {
        val bytes = File("/Users/mariojavier0795/Documents/Repositorios/rest-gestor-documental/ComprobantePagoIESS.pdf").readBytes()
        val base64 = Base64.getEncoder().encodeToString(bytes)
        val image64 = "data:application/pdf;base64,"+base64
        val obj = URL("https://api.ocr.space/parse/image")
        val con = obj.openConnection() as HttpsURLConnection
        con.requestMethod = "POST"
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5")
        val postDataParam = JSONObject()
        postDataParam.put("apikey", "67e50e34d288957")
        postDataParam.put("isOverlayRequired", "true")
        postDataParam.put("base64Image", image64)
        postDataParam.put("language", "spa")
        con.doOutput = true
        val wr = DataOutputStream(con.outputStream)
        wr.writeBytes(getPostDataString(postDataParam))
        wr.flush()
        wr.close()
        val result = StringBuffer()
        val in1 = BufferedReader(InputStreamReader(con.inputStream))
        var line = in1.readLine()
        while(line != null) {
            result.append(line)
            line = in1.readLine()
        }
        val jsonResponse = JSONObject(result.toString())
        println(result.toString())
        return ResponseEntity.ok(jsonResponse)
    }

    fun getPostDataString(params: JSONObject): String {
        val result = StringBuilder()
        var first = true
        val itr: Iterator<String> = params.keys()

        while (itr.hasNext()) {
            val key = itr.next()
            val value: Any = params.get(key)
            if (first) first = false else result.append("&")
            result.append(URLEncoder.encode(key, "UTF-8"))
            result.append("=")
            result.append(URLEncoder.encode(value.toString(), "UTF-8"))
        }
        return result.toString()
    }

}