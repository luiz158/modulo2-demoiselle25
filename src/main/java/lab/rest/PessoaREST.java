package lab.rest;

import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ValidatePayload;

@Path("pessoas")
public class PessoaREST {

	@POST
	@Transactional
	@ValidatePayload
	@Consumes("application/json")
	public void inserir(PessoaBody body) {
		System.out.println(body.nome + ", " + body.email);
	}

	public static class PessoaBody {
		@NotEmpty
		@Size(min = 3, max = 50)
		public String nome;

		@Email
		@NotEmpty
		@Size(max = 255)
		public String email;

		@Size(max = 15)
		public String telefone;
	}
	
}