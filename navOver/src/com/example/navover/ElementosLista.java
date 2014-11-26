package com.example.navover;

public class ElementosLista {
	private int foto;
	private String titulo;
    private String subtitulo;
 
    public ElementosLista(String tit, String sub, int fot){
        titulo = tit;
        subtitulo = sub;
        foto = fot;
    }
 
    public String getTitulo(){
        return titulo;
    }
 
    public String getSubtitulo(){
        return subtitulo;
    }
    
    public int getFoto(){
    	return foto;
    }
}

