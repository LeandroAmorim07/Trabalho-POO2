/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.ClienteDAO;
import dao.ConexaoHibernate;
import dao.GenericDao;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import model.Cliente;
import model.Estadia;
import model.Item;
import model.ItemPedido;
import model.PedidoSQ;
import model.Quarto;

public class DomainManeger {

    private GenericDao genDao;
    private ClienteDAO cliDao;

    public DomainManeger() throws ClassNotFoundException, SQLException {
        genDao = new GenericDao();
        cliDao = new ClienteDAO();

        ConexaoHibernate.getSessionFactory().openSession();
   

    }

    public List<Cliente> ListarCliente() {
        return genDao.listar(Cliente.class);
    }

    public List<Quarto> ListarQuarto() {
        return genDao.listar(Quarto.class);
    }

    public List<Estadia> ListarEstadia() {
        return genDao.listar(Estadia.class);
    }

    public List<ItemPedido> ListarItemPedido() {
        return genDao.listar(ItemPedido.class);
    }
    public List<PedidoSQ> ListarPedido() {
        return genDao.listar(PedidoSQ.class);
    }

    public List<Item> ListarItem() {
        return genDao.listar(Item.class);
    }

    public int inserirCliente(String nome, String telefone, String email, String cpf) {
        Cliente cli = new Cliente(nome, telefone, email, cpf);
        genDao.inserir(cli);
        return cli.getIdCliente();

    }

    public void alterarCliente(int idCliente, String nome, String telefone, String email, String cpf) throws ClassNotFoundException, SQLException {

        Cliente cli = new Cliente(idCliente, nome, telefone, email, cpf);
        genDao.alterar(cli);
    }

    public void inserirQuarto(int numQuarto, String tipoQuarto, String cama, double valorDiaria) {
        Quarto qt = new Quarto(numQuarto, tipoQuarto, cama, valorDiaria);
        genDao.inserir(qt);

    }

    public void alterarQuarto(int numQuarto, String tipoQuarto, String cama, double valorDiaria) {
        Quarto qt = new Quarto(numQuarto, tipoQuarto, cama, valorDiaria);
        genDao.alterar(qt);
    }

    public int inserirEstadia(Cliente cli, Quarto qt, Date checkin, Date checkout) {
        Estadia es = new Estadia(checkin, checkout, 0, 0, cli, qt);

        genDao.inserir(es);

        return es.getIdEstadia();
    }

    public void alterarEstadia(int idEstadia, Cliente cli, Quarto qt, Date checkin, Date checkout) {
        Estadia es = new Estadia(idEstadia, checkin, checkout, 0, 0, cli, qt);
        genDao.alterar(es);
    }

  

    public int inserirProduto(String nome, double valor) {
        Item it = new Item(nome, valor);
        genDao.inserir(it);
        return it.getIdItem();

    }

    public void alterarProduto(int idProduto, String nomeProduto, double valor) {
        Item it = new Item(idProduto, nomeProduto, valor);
        genDao.alterar(it);
    }

    // buscas 
    public Cliente buscarClientePorId(int idCliente) {
        return (Cliente) genDao.buscarPorId(Cliente.class, idCliente);
    }

    public Quarto buscarQuartoPorId(int numQuarto) {
        return (Quarto) genDao.buscarPorId(Quarto.class, numQuarto);
    }

    public void excluir(Object cli) throws SQLException, ClassNotFoundException {
        genDao.excluir(cli);
    }
    
     public int inserirPedido(Estadia es, List listaItens) {
        PedidoSQ ped = new PedidoSQ((double) 0.0,es,listaItens);
        ped.calcularValor();
        
        es.calcularValor();
        genDao.inserir(ped);
       
        return ped.getIdPedidoSQ();             
    }
     
      public List<Cliente> pesquisarCliente(String pesq, int tipo) throws SQLException, ClassNotFoundException {
        
       
        switch (tipo) {
            case 0: return cliDao.pesquisarPorNome(pesq);
            case 1: return cliDao.pesquisarPorCPF(pesq);
            case 2: return cliDao.pesquisarPorEmail(pesq);
            case 3: return cliDao.pesquisarPorTelefone(pesq);
            default : return null;
        }
        
       
        
    }
}
