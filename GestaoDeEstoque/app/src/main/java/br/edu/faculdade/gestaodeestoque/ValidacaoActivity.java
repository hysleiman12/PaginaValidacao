package br.edu.faculdade.gestaodeestoque;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;



public class ValidacaoActivity extends AppCompatActivity {
    public   static final int RESULTADO_DE_CODIGO_SUCESSO = 1;
    private String produtoParam;
    private String valorParam;
    private String fornecedorParam;
    private String quantidadeParam;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validacao);

        Intent i = getIntent();
        if(i != null){

            produtoParam = i.getStringExtra("produtoParam");
            valorParam = i.getStringExtra("valorParam");
            fornecedorParam = i.getStringExtra("fornecedorParam");
            quantidadeParam = i.getStringExtra("quantidadeParam");



            TextView tvProduto = findViewById(R.id.tvProduto);
            tvProduto.setText("Produto " +produtoParam);
            TextView tvValor = findViewById(R.id.tvValor);
            tvValor.setText("Valor " +valorParam);
            TextView tvFonercedor = findViewById(R.id.tvFornecedor);
            tvFonercedor.setText("Fornecedor " +fornecedorParam);
            TextView tvQuantidade = findViewById(R.id.tvQuantidade);
            tvQuantidade.setText("Quantidade " +quantidadeParam);
        }

    }
    public void validar(View view){

        String resposta = "";

        int quantidadeConvertido = 0;
        double valorConvertido = 0;

        try{
            valorConvertido = Double.parseDouble(valorParam);
            quantidadeConvertido = Integer.parseInt(quantidadeParam);

        }catch (NumberFormatException e){
            e.getStackTrace();
        }

        if(valorConvertido < 500){
            Toast.makeText(getBaseContext(), "O campo valor tem que ser maior que 500", Toast.LENGTH_LONG).show();

        }else if(fornecedorParam.length() < 11){
            Toast.makeText(getBaseContext(), "O campo fornecdor tem que ter um numero de caracteres maior que 11", Toast.LENGTH_LONG).show();

        }else if(quantidadeConvertido < 0){
            Toast.makeText(getBaseContext(), "O campo quantidade tem que ser maior que 0", Toast.LENGTH_LONG).show();

        }

        Intent data = new Intent();
        data.putExtra("resposta", resposta);
        setResult(RESULTADO_DE_CODIGO_SUCESSO, data);
        finish();

    }


}
