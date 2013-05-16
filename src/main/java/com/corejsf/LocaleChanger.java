package com.corejsf;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class LocaleChanger implements Serializable {

	private static final long serialVersionUID = 1L;

	public String changeLocale() {
		FacesContext context = FacesContext.getCurrentInstance();
		String languageCode = getLanguageCode(context);
		context.getViewRoot().setLocale(new Locale(languageCode));
		
		return null;
	}
	
	private String getLanguageCode(FacesContext context) {
		Map<String, String> params = context.getExternalContext().getRequestParameterMap();
		
		return params.get("languageCode");
	}
	
}
