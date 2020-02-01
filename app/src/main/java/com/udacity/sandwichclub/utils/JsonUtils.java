package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject object = new JSONObject(json);
            //set mainName
            JSONObject nameObject = object.getJSONObject("name");
            if (nameObject.has("mainName")) {
                sandwich.setMainName(nameObject.getString("mainName"));
            }
            // set alsoKnownAs
            JSONArray alsoKnownAsArray = nameObject.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<String>();
            for (int i = 0; i < alsoKnownAsArray.length(); i++) {
                alsoKnownAs.add(alsoKnownAsArray.getString(i));
            }
            sandwich.setAlsoKnownAs(alsoKnownAs);
            //set placeOfOrigin
            if (object.has("placeOfOrigin")) {
                sandwich.setPlaceOfOrigin(object.getString("placeOfOrigin"));
            }
            //set description
            if (object.has("description")) {
                sandwich.setDescription(object.getString("description"));
            }
            //set image
            if (object.has("image")) {
                sandwich.setImage(object.getString("image"));
            }
            //set ingredients
            JSONArray ingredientsArray = object.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<String>();
            for (int i = 0; i < ingredientsArray.length(); i++) {
                ingredients.add(ingredientsArray.getString(i));
                System.out.println(ingredientsArray.getString(i));
            }
            sandwich.setIngredients(ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
