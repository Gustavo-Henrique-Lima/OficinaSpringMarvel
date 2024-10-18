package com.snct.marvel.entities.enums;

public enum TipoEnum {

	HEROI(0), VILAO(1);

	private int code;

	private TipoEnum(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static TipoEnum turnStatus(int code) {
		for (TipoEnum valor : TipoEnum.values()) {
			if (valor.getCode() == code) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Código de status inválido");
	}
}
