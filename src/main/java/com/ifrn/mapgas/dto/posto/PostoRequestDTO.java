package com.ifrn.mapgas.dto.posto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostoRequestDTO {
    private String razaoSocial;
    private String nomeFantasia;
    private Boolean status;

    private String rua;
    private String cep;
    private Double latitude;
    private Double longitude;
    private String complemento;
    private Long cidadeId;
}
