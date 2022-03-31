package com.bootcampjava.starwars.Bootcamp.Java.Star.Wars.repository;

import com.bootcampjava.starwars.Bootcamp.Java.Star.Wars.model.Jedi;
import com.bootcampjava.starwars.Bootcamp.Java.Star.Wars.service.JediService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JediRepositoryImpl implements JediRepository {

    private static final Logger logger = LogManager.getLogger(JediService.class);

    private final JdbcTemplate jdbcTemplate;

    private final SimpleJdbcInsert simpleJdbcInsert;

    public JediRepositoryImpl(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;

        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("jedis").usingGeneratedKeyColumns("id");
    }

    @Override
    public Optional<Jedi> findById(Integer id) {
        try {
            Jedi jedi = jdbcTemplate.queryForObject("SELECT * FROM jedis WHERE id = ?", new Object[]{id},
                    (rs, rowNum) -> {
                        Jedi p = new Jedi();
                        p.setId(rs.getInt("id"));
                        p.setName(rs.getString("name"));
                        p.setStrength(rs.getInt("strength"));
                        p.setVersion(rs.getInt("version"));
                        return p;
                    })
            return Optional.of(jedi);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Jedi> findAll() {
        return jdbcTemplate.queryForObject("SELECT * FROM jedis",
                (rs, rowNum) -> {
                    Jedi p = new Jedi();
                    p.setId(rs.getInt("Id");
                    p.setName(rs.getString("name"));
                    p.setStrength(rs.getInt("strength"));
                    p.setVersion(rs.getInt("version"));
                    return p;
                }
    }

    @Override
    public boolean update(Jedi jedi) {
        return jdbcTemplate.queryForObject("UPDATE jedis SET name = ?, strength = ?, version = ? WHERE id = ?", new Object[]{id},
                jedi.getName();
        jedi.getStrength();
        jedi.getVersion();
        jedi.getId()) ==1;
    }

    @Override
    public Jedi save(Jedi jedi) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("name", jedi.getName());
        parameters.put("strength", jedi.getStrength());
        parameters.put("version", jedi.getVersion());

        Number newId = simpleJdbcInsert.executeAndReturnKey(parameters);

        logger.info("Inserting Jedi intro database, generated id is: {}", newId);

        jedi.setId((Integer) newId);

        return jedi;
    }

    @Override
    public boolean delete(Integer id) {
        return jdbcTemplate.update("DELETE FROM jedis WHERE id = ?", id) == 1;
    }
}
