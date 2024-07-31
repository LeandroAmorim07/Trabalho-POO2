/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.ClienteDAO;
import dao.ConexaoHibernate;
import dao.EstadiaDAO;
import dao.GenericDao;
import dao.ItemDAO;
import dao.QuartoDAO;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Estadia;
import model.Item;
import model.ItemPedido;
import model.PedidoSQ;
import model.Quarto;

public class DomainManeger {

    private GenericDao genDao;
    private ClienteDAO cliDao;
    private QuartoDAO quartoDao;
    private ItemDAO itemDao;
    private EstadiaDAO estadiaDao;
    

    public DomainManeger() throws ClassNotFoundException, SQLException {
        genDao = new GenericDao();
        cliDao = new ClienteDAO();
        quartoDao = new QuartoDAO();
        itemDao=new ItemDAO();
        estadiaDao = new EstadiaDAO();
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

    public Cliente inserirCliente(String nome, String telefone, String email, String cpf) {
        Cliente cli = new Cliente(nome, telefone, email, cpf);
        genDao.inserir(cli);
        return cli;

    }

    public void alterarCliente(int idCliente, String nome, String telefone, String email, String cpf) throws ClassNotFoundException, SQLException {

        Cliente cli = new Cliente(idCliente, nome, telefone, email, cpf);
        genDao.alterar(cli);
    }

    public Quarto inserirQuarto(int numQuarto, String tipoQuarto, String cama, double valorDiaria) {
        Quarto qt = new Quarto(numQuarto, tipoQuarto, cama, valorDiaria);
        genDao.inserir(qt);
        return qt;

    }

    public void alterarQuarto(int numQuarto, String tipoQuarto, String cama, double valorDiaria) {
        Quarto qt = new Quarto(numQuarto, tipoQuarto, cama, valorDiaria);
        genDao.alterar(qt);
    }

    public Estadia inserirEstadia(Cliente cli, Quarto qt, Date checkin, Date checkout, double valorTotalEstadia) {
        Estadia es = new Estadia(checkin, checkout, 0, valorTotalEstadia, cli, qt);

        genDao.inserir(es);

        return es;
    }

    public void alterarEstadia(int idEstadia, Cliente cli, Quarto qt, Date checkin, Date checkout, double valorTotalEstadia, double valorTotalSQ) {
        Estadia es = new Estadia(idEstadia, checkin, checkout, valorTotalSQ, valorTotalEstadia, cli, qt);
        genDao.alterar(es);
    }

    public Item inserirProduto(String nome, double valor) {
        Item it = new Item(nome, valor);
        genDao.inserir(it);
        return it;

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

 
     public PedidoSQ inserirPedidosq(Estadia es, List listaItens) {
        PedidoSQ ped = new PedidoSQ((double) 0.0, es, listaItens);
        ped.calcularValor();
        
        es.calcularValor();
        genDao.inserir(ped);

        return ped;
    }

    public List<Estadia> pesquisarEstadia(String pesq, int tipo) throws SQLException, ClassNotFoundException {

        switch (tipo) {
            case 0:
                return estadiaDao.pesquisarPorIdCliente(pesq);
            case 1:
                return estadiaDao.pesquisarPorNumQuarto(pesq);
            default:
                return null;
        }
    }
        public void relGroupBy(JTable tabela, String pesq, int tipo) throws Exception {
    List<Estadia> lista = null;

    // Limpa a tabela
    ((DefaultTableModel) tabela.getModel()).setRowCount(0);

    switch (tipo) {
        case 0:
            lista = estadiaDao.pesquisarPorIdCliente(pesq);
            break;
        case 1:
            lista = estadiaDao.pesquisarPorNumQuarto(pesq);
            break;
    }

    NumberFormat formato = NumberFormat.getCurrencyInstance();

        if (lista != null) {
        for (Estadia estadia : lista) {
            Object[] rowData = {
                              // exemplo de campo
                estadia.getCliente().getIdCliente(), // exemplo de campo
                estadia.getQuarto().getNumQuarto(), // exemplo de campo
                
                formato.format(estadia.getValortotalSQ()),
                formato.format(estadia.getValorTotalEstadia())// exemplo de campo formatado
                // Adicione outros campos conforme necessário
            };

            ((DefaultTableModel) tabela.getModel()).addRow(rowData);
        }

        }
    }
        
        
       

    
    public List<Cliente> pesquisarCliente(String pesq, int tipo) throws SQLException, ClassNotFoundException {

        switch (tipo) {
            case 0:
                return cliDao.pesquisarPorNome(pesq);
            case 1:
                return cliDao.pesquisarPorCPF(pesq);
            case 2:
                return cliDao.pesquisarPorEmail(pesq);
            case 3:
                return cliDao.pesquisarPorTelefone(pesq);
            default:
                return null;
        }
    }
    public List<Quarto> pesquisarQuarto(String pesq) {
        return quartoDao.pesquisar(pesq);
    }
    
   public List<Item> pesquisarItem(String pesq) {
        return itemDao.pesquisar(pesq);
    }

}
