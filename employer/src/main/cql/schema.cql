DROP KEYSPACE IF EXISTS employer;

CREATE KEYSPACE employer WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 3 };

CREATE TYPE employer.address (
    street text,
    streetExt text,
    state text,
    zip text,
    country text
);

CREATE TYPE employer.nameInfo (
    first text,
    last text,
    middle text
);

CREATE TYPE employer.department (
    code text,
    name text
);

CREATE TYPE employer.office (
    code text,
    name text,
    address frozen <address>
);

CREATE TABLE employer.employer (
    id TimeUUID PRIMARY KEY,
    name text,
    address frozen <address>,
    departments set<frozen <department>>,
    offices set<frozen <office>>,
    description text
);

CREATE TABLE employer.employee (
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

CREATE TABLE employer.employeeUpdate (
    id TimeUUID PRIMARY KEY,
    employeeId TimeUUID,
    effective date,
    address frozen <address>,
    phone text
);

CREATE INDEX employer_name_index ON employer.employer (name);
CREATE INDEX employee_employer_index ON employer.employee (employerId);
CREATE INDEX employeeUpdate_employee_index ON employer.employeeUpdate (employeeId);