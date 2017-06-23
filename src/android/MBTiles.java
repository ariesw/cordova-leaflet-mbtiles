package uk.co.dbyz.cordova.leaflet.mbtiles;

import org.apache.cordova.*;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.DecoderException;
import org.json.JSONArray;
import org.json.JSONException;

public class MBTiles extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
		
        if (action.equals("hextob64")) {
            //convert String to char array (1st step)
            char[] charArray = data.getString(0).toCharArray();
            
			try {
				// decode the char array to byte[] (2nd step)
				byte[] decodedHex = Hex.decodeHex(charArray);

				// The String decoded to Base64 (3rd step)
				String result= new String(Base64.encodeBase64(decodedHex));
					
				callbackContext.success(result);
			}catch(DecoderException ex){
				callbackContext.error(ex.getMessage());
			}
            return true;

        } else {
            
            return false;

        }
    }
}
