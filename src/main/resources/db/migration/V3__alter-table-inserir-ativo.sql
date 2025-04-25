alter table conserto add ativo tinyint;

update conserto set ativo = 1;

ALTER TABLE conserto ALTER COLUMN ativo set not null;