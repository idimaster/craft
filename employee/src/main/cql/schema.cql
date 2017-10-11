DROP KEYSPACE IF EXISTS employee;

CREATE KEYSPACE employee WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 3 };

CREATE TYPE employee.address (
    street text,
    streetExt text,
    state text,
    zip text,
    country text
);

CREATE TYPE employee.nameInfo (
    first text,
    last text,
    middle text
);

CREATE TYPE employee.department (
    code text,
    name text
);

CREATE TYPE employee.office (
    code text,
    name text,
    address frozen <address>
);

CREATE TABLE employee.employer (
    id TimeUUID PRIMARY KEY,
    name text,
    address frozen <address>,
    departments set<frozen <department>>,
    offices set<frozen <office>>,
    description text
);

CREATE TABLE employee.employee (
    id TimeUUID PRIMARY KEY,
    employerId TimeUUID,
    name frozen <nameInfo>,
    email text,
    department text,
    office text,
    address frozen <address>,
    ssn text,
    phone text,
    dob date,
    gender text,
    maritalStatus text,
    annualPay int
);

CREATE TABLE employee.employeeUpdate (
    id TimeUUID PRIMARY KEY,
    employeeId TimeUUID,
    effective date,
    address frozen <address>,
    phone text
);

CREATE INDEX employer_name_index ON employee.employer (name);
CREATE INDEX employee_employer_index ON employee.employee (employerId);
CREATE INDEX employeeUpdate_employee_index ON employee.employeeUpdate (employeeId);