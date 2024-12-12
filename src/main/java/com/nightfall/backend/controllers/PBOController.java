package com.nightfall.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nightfall.backend.models.PBO_Pagi;
@RestController
@RequestMapping("/api/pbo")
public class PBOController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/pagi")
    public List<PBO_Pagi> getPBO_PagiData() {
        String sql = "SELECT * FROM public.\"products\"";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 
            new PBO_Pagi(
                rs.getLong("id"),
                rs.getString("nama"),
                rs.getString("alamat"),
                rs.getBigDecimal("telepon")
            )
        );
    }
}
