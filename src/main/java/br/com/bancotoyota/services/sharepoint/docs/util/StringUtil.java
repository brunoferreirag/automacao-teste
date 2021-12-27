package br.com.bancotoyota.services.sharepoint.docs.util;

import br.com.bancotoyota.services.sharepoint.docs.common.Constants;

public class StringUtil {
	private StringUtil() {
		
	}
	
	public static String removeBarraNoPrimeiroCaractere(String texto) {
		if (texto.startsWith(Constants.BARRA)) {
			texto=texto.replaceFirst(Constants.BARRA, "").trim();
		}
		return texto;
	}
}
