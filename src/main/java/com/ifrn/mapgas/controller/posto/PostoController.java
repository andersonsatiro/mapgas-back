package com.ifrn.mapgas.controller.posto;

import com.ifrn.mapgas.domain.posto.Posto;
import com.ifrn.mapgas.dto.posto.PostoRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ifrn.mapgas.service.posto.PostoService;

@RestController
@RequestMapping("/postos")
public class PostoController {

    private final PostoService postoService;

    public PostoController(PostoService postoService) {
        this.postoService = postoService;
    }

    @PostMapping
    public ResponseEntity<Posto> createPosto(@RequestBody PostoRequestDTO dto) {
        Posto postoCreated = postoService.createPosto(dto);
        return new ResponseEntity<>(postoCreated, HttpStatus.CREATED);
    }
}
