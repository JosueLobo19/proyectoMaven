package com.microserviceproyecto.models.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proyecto")

public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto")
    private long id;

    @Column(name = "cod_generado", length = 20)
    private String codGenerado;

    @Column(name = "finalidad_proy", length = 200)
    private String finalidadProyecto;

    @Column(length = 50)
    private String estado;

    @Column(name = "suopervisor_gdpe", length = 200)
    private String supervisorGDPE;

    @Column(name = "id_emp_proy")
    private long idEmpresaProyectista;

    @Column(name = "id_pers_proy")
    private long idPersonaProyectista;

    @Column(name = "nombre_proy", length = 200)
    private String nombreProyecto;

    private String departamento;

    private String provincia;

    private String distrito;

    private long ubigeo;

    @Column(length = 200)
    private String localidad;

    @Column(name = "id_sistema")
    private long idSistema;

    @Column(name = "coord_umt_x")
    private float coordUtmX;

    @Column(name = "coord_umt_Y")
    private float coordUtmY;

    @Column(name = "ubicac_proy", length = 200)
    private String ubicacionProyecto;

    @Column(nullable = false, name = "id_pers_interesado")
    private long idPersonaInteresada;

    @Column(nullable = false, name = "id_tipo_proy")
    private long idTipoProyecto;

    @Column(nullable = false, name = "id_tipo_financ")
    private long idTipoFinanciamiento;

    @Column(name = "detalle_financ")
    private String detalleFinanciamiento;

    @Column(name = "cantidad_benef")
    private long cantidadBeneficiarios;

    @Column(name = "dem_potencia")
    private float demPotencia;

    @Column(name = "nivel_tesion")
    private long nivelTension;

    @Column(name = "longit_proy")
    private long longitudProyecto;

    private long inversion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_registro")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    @Column(name = "user_registro")
    private String userRegistro;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_upd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaActualizacion;

    @Column(name = "user_upd")
    private String userActualizacion;

    @JsonBackReference
    @OneToMany(mappedBy="proyecto", cascade= CascadeType.ALL,orphanRemoval = true)
    private Set<Fase> fase=new HashSet<>();
}
