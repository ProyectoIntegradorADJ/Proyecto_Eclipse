package com.dam.maven.GuiaMichelin.main;

import java.awt.EventQueue;

import com.dam.maven.GuiaMichelin.control.GMListener;
import com.dam.maven.GuiaMichelin.view.PConsultaRestaurante;
import com.dam.maven.GuiaMichelin.view.PModificarRestaurante;
import com.dam.maven.GuiaMichelin.view.PRegistroRestaurante;
import com.dam.maven.GuiaMichelin.view.VPrincipalGuiaM;

public class IniciarApp {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VPrincipalGuiaM vPGM = new VPrincipalGuiaM();
				PConsultaRestaurante pCR = new PConsultaRestaurante();
				PRegistroRestaurante pRR = new PRegistroRestaurante();
				PModificarRestaurante pMR = new PModificarRestaurante();
				GMListener listener = new GMListener(vPGM, pCR, pRR, pMR);
				
				vPGM.setListener(listener);
				pCR.setListener(listener);
				pRR.setListener(listener);
				pMR.setListener(listener);
				
				vPGM.hacerVisible();
				
			}
		});
		
	}

}
