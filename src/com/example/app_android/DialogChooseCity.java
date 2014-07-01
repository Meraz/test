package com.example.app_android;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class DialogChooseCity extends DialogFragment {	
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("Välj Startposition");
		builder.setItems(
				R.array.cities_dialog, new DialogInterface.OnClickListener() {			
					@Override
					public void onClick(DialogInterface dialog, int option) {
						Intent intent = new Intent(getActivity().getApplicationContext(), ActivityMap.class);
						assert option <= 0 && option >= 2;
						if(option == 0 || option == 1) {
							intent.putExtra("entryID", 0);
							intent.putExtra("startPositionID", option);
							intent.putExtra("room", "unknown");
						}
						startActivity(intent);
					}
				});
		Dialog dialog = builder.create();
		return dialog;		
	}	
}