-- =========================
-- TABLA: Direccion
-- =========================
CREATE TABLE Direccion (
    ID_dir INT PRIMARY KEY,
    Calle VARCHAR(50),
    Despacho VARCHAR(20),
    CP VARCHAR(5),
    Numero INT
);

-- =========================
-- TABLA: Ubicacion
-- =========================
CREATE TABLE Ubicacion (
    Cod INT PRIMARY KEY,
    Edificio VARCHAR(50),
    Planta VARCHAR(10),
    Departamento VARCHAR(50),
    ID_dir INT,
    CONSTRAINT fk_ubicacion_direccion
        FOREIGN KEY (ID_dir)
        REFERENCES Direccion(ID_dir)
);

-- =========================
-- TABLA: Departamento
-- =========================
CREATE TABLE Departamento (
    ID_Dep INT PRIMARY KEY,
    Nombre VARCHAR(50),
    Presupuesto NUMERIC(7,2),
    Ubicacion INT,
    CONSTRAINT fk_departamento_ubicacion
        FOREIGN KEY (Ubicacion)
        REFERENCES Ubicacion(Cod)
);

-- =========================
-- TABLA: Rol
-- =========================
CREATE TABLE Rol (
    ID_Rol INT PRIMARY KEY,
    Nombre_rol VARCHAR(30)
);

-- =========================
-- TABLA: Dispositivos
-- =========================
CREATE TABLE Dispositivos (
    MAC VARCHAR(17) PRIMARY KEY,
    IP VARCHAR(15),
    Modelo VARCHAR(50),
    Sistema_operativo VARCHAR(50)
);

-- =========================
-- TABLA: Incidencias
-- (se crea antes de Empleado por dependencias circulares)
-- =========================
CREATE TABLE Incidencias (
    Num_Incidencia INT PRIMARY KEY,
    Estado VARCHAR(20),
    DNI_Empleado VARCHAR(9),
    DNI_Responsable VARCHAR(9),
    Fecha_alta DATE,
    Fecha_resolucion DATE,
    Dispositivo_afect VARCHAR(17)
);

-- =========================
-- TABLA: Empleado
-- =========================
CREATE TABLE Empleado (
    DNI VARCHAR(9) PRIMARY KEY,
    Nombre VARCHAR(30),
    Apellidos VARCHAR(50),
    Fecha_contrato DATE,
    Salario DECIMAL(10,2),
    Teletrabajo BOOLEAN,
    Tlf VARCHAR(15) CHECK (Tlf LIKE '346%'),
    Tlf_trabajo VARCHAR(15) CHECK (Tlf_trabajo LIKE '346%'),
    ID_Dep INT,
    ID_Rol INT,
    Dispositivo_asignado VARCHAR(17),
    Num_dirige INT,
    Num_gestiona INT,

    CONSTRAINT fk_empleado_departamento
        FOREIGN KEY (ID_Dep)
        REFERENCES Departamento(ID_Dep),

    CONSTRAINT fk_empleado_rol
        FOREIGN KEY (ID_Rol)
        REFERENCES Rol(ID_Rol),

    CONSTRAINT fk_empleado_dispositivo
        FOREIGN KEY (Dispositivo_asignado)
        REFERENCES Dispositivos(MAC)
);

-- =========================
-- AÑADIR FKs DESPUÉS (por dependencias circulares)
-- =========================

-- Incidencias → Empleado
ALTER TABLE Incidencias
ADD CONSTRAINT fk_incidencias_empleado
FOREIGN KEY (DNI_Empleado)
REFERENCES Empleado(DNI);

ALTER TABLE Incidencias
ADD CONSTRAINT fk_incidencias_responsable
FOREIGN KEY (DNI_Responsable)
REFERENCES Empleado(DNI);

-- Incidencias → Dispositivos
ALTER TABLE Incidencias
ADD CONSTRAINT fk_incidencias_dispositivo
FOREIGN KEY (Dispositivo_afect)
REFERENCES Dispositivos(MAC);

-- Empleado → Incidencias
ALTER TABLE Empleado
ADD CONSTRAINT fk_empleado_dirige
FOREIGN KEY (Num_dirige)
REFERENCES Incidencias(Num_Incidencia);

ALTER TABLE Empleado
ADD CONSTRAINT fk_empleado_gestiona
FOREIGN KEY (Num_gestiona)
REFERENCES Incidencias(Num_Incidencia);