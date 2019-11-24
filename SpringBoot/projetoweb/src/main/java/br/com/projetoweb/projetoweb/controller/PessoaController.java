//package br.com.projetoweb.projetoweb.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//
//// Classe Pessoa
//// Repositorio Pessoa
//
//
//@RestController
//public class PessoaController {
//    @Autowired
//    private PessoaRepository _pessoaRepository;
//
//
//    // Method GET
//    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
//    public List<Pessoa> Get() {
//        return _pessoaRepository.findAll();
//    }
//
//
//    // Method GET ById
//    @RequestMapping(value = "/pessoa/{pessoaId}", method = RequestMethod.GET)
//    public ResponseEntity<Pessoa> GetById(@PathVariable(value = "pessoaId") long pessoaId)
//    {
//        Optional<Pessoa> pessoa = _pessoaRepository.findById(pessoaId);
//        if(pessoa.isPresent())
//            return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
//        else
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//
//    // Method POST
//    @RequestMapping(value = "/pessoa", method =  RequestMethod.POST)
//    public Pessoa Post(@Valid @RequestBody Pessoa pessoa)
//    {
//        return _pessoaRepository.save(pessoa);
//    }
//
//
//    // Method PUT
//    @RequestMapping(value = "/pessoa/{pessoaId}", method =  RequestMethod.PUT)
//    public ResponseEntity<Pessoa> Put(@PathVariable(value = "pessoaId") long pessoaId, @Valid @RequestBody Pessoa newPessoa)
//    {
//        Optional<Pessoa> oldPessoa = _pessoaRepository.findById(pessoaId);
//        if(oldPessoa.isPresent()){
//            Pessoa pessoa = oldPessoa.get();
//            pessoa.setNome(newPessoa.getNome());
//            pessoa.setSobrenome(newPessoa.getSobrenome());
//            pessoa.setCpf(newPessoa.getCpf());
//            _pessoaRepository.save(pessoa);
//            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
//        }
//        else
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//
//    // Method DELETE ById
//    @RequestMapping(value = "/pessoa/{pessoaId}", method = RequestMethod.DELETE)
//    public ResponseEntity<Object> Delete(@PathVariable(value = "pessoaId") long pessoaId)
//    {
//        Optional<Pessoa> pessoa = _pessoaRepository.findById(pessoaId);
//        if(pessoa.isPresent()){
//            _pessoaRepository.delete(pessoa.get());
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        else
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//}