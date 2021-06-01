package com.paciente.domain.enumerate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.paciente.domain.response.TelefoneResponse;

public enum TipoTelefoneEnum {
	RESIDENCIAL(0, "RESIDENCIAL"), CELULAR(1, "CELULAR"), COMERCIAL(2, "COMERCIAL");

	private int code;
	private String desc;

	private TipoTelefoneEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static List<TelefoneResponse> all() {
		List<TelefoneResponse> lTipoTelefone = new ArrayList<>();
		Arrays.asList(TipoTelefoneEnum.values()).stream().forEach(tipoTelefone -> {
			lTipoTelefone.add(new TelefoneResponse(tipoTelefone.getCode(), tipoTelefone.getDesc()));
		});

		return lTipoTelefone;
	}

}
