package es.cic.curso00.curso00ejerc17.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.cic.curso00.curso00ejerc17.model.Producto;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProductoException extends RuntimeException{

	private static final long serialVersionUID = 7425995306612872355L;

	private final Producto producto;

	public ProductoException(String message, Producto producto) {
		super(message);
		this.producto = producto;
	}

	@Override
	public String getMessage() {
		return String.format(super.getMessage(), producto.toString());
	}
}
