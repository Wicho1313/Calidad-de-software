DROP TABLE IF EXISTS profes;
create TABLE profes(
    cedulaProfe int(11) NOT NULL,
    NombreProfe varchar(25) NOT NULL,
    PRIMARY KEY (cedulaProfe, NombreProfe)
);

DROP TABLE IF EXISTS estudiantes;
create TABLE estudiantes(
    cedulaEstudiante int(11) NOT NULL,
    NombreEstudiante varchar(25) DEFAULT NULL,
    calificacion varchar(25) DEFAULT NULL,
    PRIMARY KEY (cedulaEstudiante)
);

DROP TABLE IF EXISTS coordinadores;
create TABLE coordinadores(
    cedulaCoordi int(11) NOT NULL,
    NombreCoordi varchar(25) DEFAULT NULL,
    cargo varchar(25) DEFAULT NULL,
    PRIMARY KEY (cedulaCoordi)
);

DROP TABLE IF EXISTS cursos;
create Table cursos(
    NombreCurso varchar(25) DEFAULT NULL,
    Termino varchar(25) DEFAULT NULL,
    codigo int(11) NOT NULL,
    Profe varchar(25) NOT NULL,
    PRIMARY KEY (codigo)
    );

INSERT INTO cursos VALUES ('Calidad','12/12/12','2014010995','Leonel Nossa Ortiz')
