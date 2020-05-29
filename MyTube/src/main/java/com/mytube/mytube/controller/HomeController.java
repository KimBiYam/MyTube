package com.mytube.mytube.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@ResponseBody
	@GetMapping("/youtube")
	public JSONArray youtube(String search) throws Exception {

		String apiurl = "https://www.googleapis.com/youtube/v3/search";
		apiurl += "?key=AIzaSyCXQpmMdSqA9Rkx0FL2VPkBgo4fOebbFzs";
		apiurl += "&part=snippet&type=video&maxResults=20&videoEmbeddable=true";
		apiurl += "&q=" + URLEncoder.encode(search, "UTF-8");

		URL url = new URL(apiurl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}

		br.close();

		JSONParser parser = new JSONParser();

		JSONObject obj = (JSONObject) parser.parse(response.toString());
		JSONArray items = (JSONArray) obj.get("items");
		
		System.out.println(items.toString());
		
		return items;

	}

}
