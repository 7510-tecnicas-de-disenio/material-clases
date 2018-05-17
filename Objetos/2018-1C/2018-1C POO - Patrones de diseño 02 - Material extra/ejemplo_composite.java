
public abstract class Grafico {
	public abstract void dibujar();
}

public class Texto {
	public void dibujar() {
		[...]
	}
}
public class Linea {
	public void dibujar() {
		[...]
	}
}
public class Figura {
	public void dibujar() {
		[...]
	}
}
public class Imagen {
	
	private List<Grafico> misGraficos;
	
	[...]
	
	public void dibujar() {
		[...]
		for (Grafico grafico : misGraficos) {
			grafico.dibujar()
		}
		[...]
	}
}




