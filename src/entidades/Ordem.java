package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.enumeradores.StatusOrdem;

public class Ordem {
	private Date dataOrdem;
	private StatusOrdem statusOrdem;
	private Clientes cliente;
	private List<ItemOrdem> itensOrdem = new ArrayList<>();
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:yyyy");
	public Ordem() {

	}

	public Ordem(Date dataOrdem, StatusOrdem statusOrdem, Clientes cliente) {
		this.dataOrdem = dataOrdem;
		this.statusOrdem = statusOrdem;
		this.cliente = cliente;
	}

	public Date getDataOrdem() {
		return dataOrdem;
	}

	public void setDataOrdem(Date dataOrdem) {
		this.dataOrdem = dataOrdem;
	}

	public StatusOrdem getStatusOrdem() {
		return statusOrdem;
	}

	public void setStatusOrdem(StatusOrdem statusOrdem) {
		this.statusOrdem = statusOrdem;
	}

	public List<ItemOrdem> getItens() {
		return itensOrdem;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public void adicionaItem(ItemOrdem itemOrdem) {
		itensOrdem.add(itemOrdem);
	}

	public void removeItem(ItemOrdem itemOrdem) {
		itensOrdem.remove(itemOrdem);
	}

	public Double total() {
		double sum = 0;
		for (ItemOrdem c : itensOrdem) {
			sum += c.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Data da Odem: ");
		sb.append(sdf.format(dataOrdem) + "\n");
		sb.append("Status da Ordem: ");
		sb.append(statusOrdem + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Itens da Ordem:");

		for (ItemOrdem o : itensOrdem) {
			sb.append(o + "\n");
		}
		sb.append("Total: R$ ");
		sb.append(String.format("%.2f", total()));

		return sb.toString();		
	}
	
	
}