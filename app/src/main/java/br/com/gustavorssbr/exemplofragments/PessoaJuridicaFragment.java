package br.com.gustavorssbr.exemplofragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import br.com.gustavorssbr.exemplofragments.controller.IOperacao;
import br.com.gustavorssbr.exemplofragments.controller.OperacaoPJ;
import br.com.gustavorssbr.exemplofragments.model.PessoaJuridica;


public class PessoaJuridicaFragment extends Fragment {

    EditText etCnpjPj;
    EditText etNomePj;
    EditText etEmailPj;
    Button btnCadastrarPj;
    TextView tvListaPj;



    public PessoaJuridicaFragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pessoa_juridica, container, false);
        etCnpjPj = view.findViewById(R.id.etCnpjPj);
        etNomePj = view.findViewById(R.id.etNomePj);
        etEmailPj = view.findViewById(R.id.etEmailPj);
        btnCadastrarPj = view.findViewById(R.id.btnCadastrarPj);
        tvListaPj = view.findViewById(R.id.tvListaPj);
        tvListaPj.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btnCadastrarPj.setOnClickListener(op -> cadastro());

        return view;
    }

    private void cadastro() {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();

        pessoaJuridica.setNome(etNomePj.getText().toString());
        pessoaJuridica.setEmail(etEmailPj.getText().toString());
        pessoaJuridica.setCnpj(etCnpjPj.getText().toString());

        IOperacao<PessoaJuridica> op = new OperacaoPJ();

        op.cadastrar(pessoaJuridica);

        List<PessoaJuridica> lista = op.listar();

        StringBuffer buffer = new StringBuffer();

        lista.forEach(e -> buffer.append(e).append("\n"));

        tvListaPj.setText(buffer.toString());
        limpaCampos();
    }

    private void limpaCampos() {
        etEmailPj.setText("");
        etNomePj.setText("");
        etCnpjPj.setText("");

    }
}