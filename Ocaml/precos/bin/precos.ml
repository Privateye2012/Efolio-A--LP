
(*

Author : Nilde Carvalhais


*)


let read_file filename =
  let lines = ref [] in
  let channel = open_in filename in
  try
    while true do
      lines := input_line channel :: !lines
    done; []
  with End_of_file ->
    close_in channel;
    List.rev !lines

let parse_discount line =
  let regexp = Str.regexp "discount(\\(.*\\), \\(.*\\))." in
  if Str.string_match regexp line 0 then
    Some (Str.matched_group 1 line, float_of_string (Str.matched_group 2 line))
  else
    None

let parse_item line =
  let regexp = Str.regexp "item(\\(.*\\), '\\(.*\\)', '\\(.*\\)', \\(.*\\), \\(.*\\))." in
  if Str.string_match regexp line 0 then
    Some (int_of_string (Str.matched_group 1 line), Str.matched_group 2 line, Str.matched_group 3 line, float_of_string (Str.matched_group 4 line), int_of_string (Str.matched_group 5 line))
  else
    None

let parse_loyalty_discount line =
  let regexp = Str.regexp "loyalty_discount(\\(.*\\), \\(.*\\))." in
  if Str.string_match regexp line 0 then
    Some (Str.matched_group 1 line, float_of_string (Str.matched_group 2 line))
  else
    None

let parse_shipping_cost line =
  let regexp = Str.regexp "shipping_cost('\\(.*\\)', \\(.*\\))." in
  if Str.string_match regexp line 0 then
    Some (Str.matched_group 1 line, float_of_string (Str.matched_group 2 line))
  else
    None

(* Mostra o que foi lido *)
let show () =
  let file_lines = read_file "store.pl" in
  let discounts = List.filter_map parse_discount file_lines in
  let items = List.filter_map parse_item file_lines in
  let loyalty_discounts = List.filter_map parse_loyalty_discount file_lines in
  let shipping_costs = List.filter_map parse_shipping_cost file_lines in
  (* Print the parsed information *)
  List.iter (fun (category, discount) -> Printf.printf "Discount for category %s: %f\n" category discount) discounts;
  List.iter (fun (id, name, category, price, quantity) -> Printf.printf "Item: %d, %s, %s, %f, %d\n" id name category price quantity) items;
  List.iter (fun (years, discount) -> Printf.printf "Loyalty discount for %s year(s): %f\n" years discount) loyalty_discounts;
  List.iter (fun (district, cost) -> Printf.printf "Shipping cost to district %s: %f\n" district cost) shipping_costs

(*
 * Define o tipo item
 *)
type item = {
    id : int;
    nome : string;
    categoria : string;
    quantidade : float;
}

(* Mostra o conteudo de um item *)
let print_item_info item =
  Printf.printf "ID: %d, Nome: %s, Categoria: %s, Quantidade: %.2f\n"
    item.id item.nome item.categoria item.quantidade

(*
 * Recebe como parametros a lista de items do carrinho
 * Calcula o preço final sem descontos nem custos de envio
 *)
let preco_total (lista_items_str: string) =
  print_endline lista_items_str;
  let split_str = String.split_on_char ';' lista_items_str in
  let rec parse_items acc = function
    | [] -> acc
    | id_str :: nome :: categoria :: quantidade_str :: rest ->
        let id = int_of_string id_str in
        let quantidade = float_of_string quantidade_str in
        let novo_item = { id; nome; categoria; quantidade } in
        parse_items (novo_item :: acc) rest
    | _ -> failwith "String de entrada inválida"
  in

  print_endline "Preço Total: ";
  let lista_de_itens = parse_items [] split_str in
  List.iter (fun item ->
    Printf.printf "ID: %d, Nome: %s, Categoria: %s, Quantidade: %.2f\n"
      item.id item.nome item.categoria item.quantidade
  ) lista_de_itens

(*
 * Calcula os descontos por categoria
 *)
let descontos_categoria () =
  print_endline "Descontos Categoria"

let descontos_lealdade () =
  print_endline "Descontos Lealdade"

let custos_envio () =
  print_endline "Custos de envio"

let preco_final () =
  print_endline "Preço final"

let mostra_carrinho () =
  print_endline "Mostra carrinho"

(*
 * Funcao principal que trata de executar o que for necessario
 * de acordo com o primeiro parametro que pode ser:
 *)
let main () =
  match Array.length Sys.argv with
  | 1 -> print_endline "Por favor, forneça um argumento para selecionar a função a ser executada."
  | _ ->
    begin
      match Sys.argv.(1) with
      | "preco_total" -> preco_total Sys.argv.(2);
      | "descontos_categoria" -> descontos_categoria();
      | "descontos_lealdade" -> descontos_lealdade();
      | "custos_envio" -> custos_envio()
      | "preco_final" -> preco_final()
      | "mostra_carrinho" -> mostra_carrinho()
      | "show" -> show()
      | "print_item" ->  print_item_info { id = 1; nome = "Potion of Healing"; categoria = "potions"; quantidade = 2.3 }
      | _ -> print_endline "Argumento inválido. Por favor, forneça '1' ou '2'."
    end




(* Ponto de entrada no programa *)
let () = main ()