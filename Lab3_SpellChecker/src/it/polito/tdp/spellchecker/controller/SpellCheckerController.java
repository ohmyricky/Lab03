package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {
	
	private Dictionary model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Combobox"
    private ComboBox<String> Combobox; // Value injected by FXMLLoader

    @FXML // fx:id="txtInput"
    private TextArea txtInput; // Value injected by FXMLLoader

    @FXML // fx:id="btnSpellCheck"
    private Button btnSpellCheck; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="lblErrori"
    private Label lblErrori; // Value injected by FXMLLoader

    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtInput.clear();
    	txtResult.clear();

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	String input=txtInput.getText();
    	String lang=Combobox.getValue();
    	
    	input=input.toLowerCase();
    	input=input.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]]", "");
    	
    	List<String>parole=new ArrayList<String>();
    	
    	model.loadDictionary(lang);
    	
		StringTokenizer st=new StringTokenizer(input, " ");
		while(st.hasMoreElements()) {   //while((word=br.readLine())!=null)
		parole.add(st.nextToken());
		}
		List<RichWord> result=model.spellCheckTest(parole);
		
		//txtResult.setText(result.toString());
		
		StringBuilder richText = new StringBuilder();

		for (RichWord r : result) {
			if (!r.getCorretta()) {
				richText.append(r.getParola() + "\n");
			}
		}

		txtResult.setText(richText.toString());

    }
    
    private void setComboItems() {
		// Ottieni tutti i corsi dal model
		//corsi = model.getCorsi();

		// Aggiungi tutti i corsi alla ComboBox
		//Collections.sort(corsi);
		Combobox.getItems().add("Italiano");
		Combobox.getItems().add("English");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Combobox != null : "fx:id=\"Combobox\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblErrori != null : "fx:id=\"lblErrori\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }
    
    public void setModel(Dictionary model) {
    	this.model=model;
		setComboItems();
	}
}
