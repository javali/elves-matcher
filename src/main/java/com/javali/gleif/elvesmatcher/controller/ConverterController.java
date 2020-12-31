package com.javali.gleif.elvesmatcher.controller;

import com.javali.gleif.elvesmatcher.model.ELF;
import com.javali.gleif.elvesmatcher.model.LegalForm;
import com.javali.gleif.elvesmatcher.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;

/**
 * @author javali on 31.12.2020.
 */
@Controller
public class ConverterController {

	private final Converter converter;

	@Autowired
	public ConverterController(Converter converter) {
		this.converter = converter;
	}

	@PostMapping("/convert")
	@ResponseBody
	public ResponseEntity<ELF> convertToElfCodeObject(@RequestBody @NotNull LegalForm legalForm) {
		try {
			return ResponseEntity.ok(converter.getElf(legalForm.getLegislation(), legalForm.getAbbreviation()));
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
