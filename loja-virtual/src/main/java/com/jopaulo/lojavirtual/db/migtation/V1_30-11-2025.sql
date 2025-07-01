select constraint_name from information_schema.constraint_column_usage
 where table_name = 'tb_usuarios_acesso' and column_name = 'acesso_id'
and constraint_name <> 'unique_acesso_user';

alter table tb_usuarios_acesso drop constraint "uk2uatp8ygefqeuhejeed3baphi";