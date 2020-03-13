package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextArea txtPrestazioni;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	//Pulisco l'area del risultato
    	txtResult.clear();
    	txtPrestazioni.clear();
    	
    	//Faccio partire il timer
    	double inizio = System.nanoTime();
    	
    	//Prendo la parola inserita dalla casella
    	String parolaInserita = txtParola.getText();
    	
    	//Interrompo il timer
    	long fine = System.nanoTime();
    	parolaInserita = parolaInserita.trim();
    
    	
    		if (parolaInserita.length() != 0) {
    			//Se la parola inserita e' valida, si inserisce nell'elenco
    			elenco.addParola(parolaInserita);
    			String risultato = "";
    			for (String p : elenco.getElenco()) {
    				risultato += p + "\n";
    			}
    			
    			txtResult.setText(risultato);
    			
    			txtPrestazioni.setText("Tempo di esecuzione:\n" + (fine-inizio)/1e9 + "secondi");
    			
    		}
    		else 
    			txtResult.appendText("Errore nell'inserimento");
    			
    		
    		txtParola.clear();
    }

   
    @FXML
    void doCancella(ActionEvent event) {
    	//faccio partire il timer
    	double inizio = System.nanoTime();
    	
    	String parolaSelezionata = txtResult.getSelectedText();
    	
    	//interrompo il timer
    	double fine = System.nanoTime();
    	
    	if (parolaSelezionata != null) {
    		elenco.cancellaParola(parolaSelezionata);
    		
    		String risultato = "";
    		for (String p : elenco.getElenco()) {
    			risultato += p + "\n";
    		}
    		
    		txtResult.setText(risultato);
    		txtPrestazioni.setText("Tempo di esecuzione:\n" + (fine-inizio)/ 1e9 + "secondi");
    	}
    	else {
    		txtPrestazioni.clear();
    		txtPrestazioni.setText("Seleziona una parola!");
    	}
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	txtParola.clear();
    	txtResult.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtPrestazioni != null : "fx:id=\"txtPrestazioni\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
