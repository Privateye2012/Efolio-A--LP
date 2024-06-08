#!/bin/bash


#
# Compila e executa o programa do carrinho de compras
#

BASE_DIR=`pwd`
JARNAME=carrinho-compras-1.jar

function clean() {
  cd $BASE_DIR
  rm -f $BASE_DIR/precos.exe $JARNAME store.pl
  cd Java/carrinho-compras
  mvn clean
  rm -rf .history
  cd $BASE_DIR
  cd Ocaml/precos
  rm -rf .history
  dune clean
}

function build() {
  cd Java/carrinho-compras
  mvn clean install -DskipTests=true
  cp target/$JARNAME $BASE_DIR
  cd $BASE_DIR
  cd Ocaml/precos
  eval $(opam config env)
  dune build
  cp _build/default/bin/precos.exe $BASE_DIR
  cp store.pl $BASE_DIR
  cd $BASE_DIR
}

function run() {
  cd $BASE_DIR
  java -jar $JARNAME
}

#
# Create the zip to deliver this work
#
function createZip() {
  cd $BASE_DIR
  clean
  cd $BASE_DIR/..
  zip -r loja.zip `basename $BASE_DIR`
}

action=$1
if [ $# -lt 1 ]
then
  action=all
fi

case $action in
  clean)
    clean
    ;;
  build)
    build
    ;;
  run)
    run
    ;;
  zip)
    createZip
    ;;
  all)
    clean
    build
    run
    ;;
esac

