CREATE DATABASE skttask;
CREATE TABLE products(
productId SERIAL PRIMARY KEY NOT NULL,
code VARCHAR(15) NOT NULL,
name VARCHAR(50) NOT NULL,
price NUMERIC(12, 2) NOT NULL);


CREATE OR REPLACE FUNCTION insertProduct(code character varying, name character varying, price numeric, OUT id int) RETURNS integer AS
$func$
BEGIN
  INSERT INTO products (code, name, price) VALUES (code, name, price)
      RETURNING products.productid INTO id;
END
$func$ LANGUAGE plpgsql;


CREATE FUNCTION getAllProducts() RETURNS setof products LANGUAGE sql AS $$
    SELECT * FROM products;
$$;	    