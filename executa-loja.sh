#!/bin/bash


#
# Compila e executa o programa do carrinho de compras
#

BASE_DIR=`pwd`

function build() {
  cd Java/carrinho-compras
  JARNAME=carrinho-compras-1.jar
  mvn clean install
  cp target/carrinho-compras-1.jar $BASE_DIR

  cd $BASE_DIR

  cd Ocaml/precos
  eval $(opam config env)
  dune build
  cp ./_build/default/bin/precos.exe $BASE_DIR
  cp store.pl $BASE_DIR
}

function run() {
  java -jar $JARNAME
}

echo "Base dir : $BASE_DIR"
build
run


