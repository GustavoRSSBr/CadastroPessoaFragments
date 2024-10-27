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
import br.com.gustavorssbr.exemplofragments.controller.OperacaoPF;
import br.com.gustavorssbr.exemplofragments.controller.OperacaoPJ;
import br.com.gustavorssbr.exemplofragments.model.PessoaFisica;


public class PessoaFisicaFragment extends Fragment {

    private View view;

    private EditText etCpfPf;
    private EditText etNomePf;
    private EditText etTelefonePf;
    private Button btnCadastrarPf;
    private TextView tvListaPf;


    public PessoaFisicaFragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_pessoa_fisica, container, false);
        etCpfPf = view.findViewById(R.id.etCpfPf);
        etNomePf = view.findViewById(R.id.etNomePf);
        etTelefonePf = view.findViewById(R.id.etTelefonePf);
        btnCadastrarPf = view.findViewById(R.id.btnCadastrarPf);
        tvListaPf = view.findViewById(R.id.tvListaPf);
        tvListaPf.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btnCadastrarPf.setOnClickListener(op -> cadastro());

        return view;
    }

    private void cadastro() {
        PessoaFisica pf = new PessoaFisica();
        pf.setCpf(etCpfPf.getText().toString());
        pf.setNome(etNomePf.getText().toString());
        pf.setTelefone(etTelefonePf.getText().toString());

        IOperacao<PessoaFisica> op = new OperacaoPF();

        op.cadastrar(pf);

        List<PessoaFisica> lista = op.listar();

        StringBuffer buffer = new StringBuffer();

        lista.forEach(e -> buffer.append(e.toString()).append("\n"));

        tvListaPf.setText(buffer.toString());
        limpaCampos();
    }

    private void limpaCampos() {
        etCpfPf.setText("");
        etNomePf.setText("");
        etTelefonePf.setText("");
    }
}