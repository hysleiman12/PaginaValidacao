package br.edu.faculdade.gestaodeestoque;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int Retorno_De_CODIGO = 0;
    /*
    • Produto (Caixa de Texto)
• Valor (Caixa de Texto)
• Fornecedor (Caixa de Texto)
• Quantidade (Caixa de Texto)
     */
    private EditText etProduto;
    private EditText etValor;
    private EditText etFornecedor;
    private EditText etQuantidade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etProduto = this.<EditText>findViewById(R.id.etProduto);
        etValor = this.<EditText>findViewById(R.id.etValor);
        etFornecedor = this.<EditText>findViewById(R.id.etFornecedor);
        etQuantidade = this.<EditText>findViewById(R.id.etQuantidade);

    }
    public void enviar(View view){

        Intent intent = new Intent(getBaseContext(), ValidacaoActivity.class);

        String produtoParam = etProduto.getText().toString();
        String valorParam = etValor.getText().toString();
        String fornecedorParam = etFornecedor.getText().toString();
        String quantidadeParam = etQuantidade.getText().toString();

        if(produtoParam.isEmpty()){
            Toast.makeText(getBaseContext(), "O campo produto está vazio!", Toast.LENGTH_LONG).show();

        }else if(valorParam.isEmpty()){
            Toast.makeText(getBaseContext(), "O campo valor está vazio!", Toast.LENGTH_LONG).show();

        }else if(fornecedorParam.isEmpty()){
            Toast.makeText(getBaseContext(), "O campo fornecedor está vazio!", Toast.LENGTH_LONG).show();

        }else if(quantidadeParam.isEmpty()){
            Toast.makeText(getBaseContext(), "O campo quantidade está vazio!", Toast.LENGTH_LONG).show();

        }
        else {

            intent.putExtra("produtoParam", produtoParam);
            intent.putExtra("valorParam", valorParam);
            intent.putExtra("fornecedorParam", fornecedorParam);
            intent.putExtra("quantidadeParam", quantidadeParam);

            startActivityForResult(intent, Retorno_De_CODIGO);
        }
    }
    public void Limpar(View view){
        etProduto.setText("");
        etValor.setText("");
        etFornecedor.setText("");
        etQuantidade.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == Retorno_De_CODIGO){
           if(resultCode == ValidacaoActivity.RESULTADO_DE_CODIGO_SUCESSO){
               String resposta = data.getStringExtra("resposta");
               Toast.makeText(getBaseContext(), resposta, Toast.LENGTH_LONG).show();

           }

        }

    }
}
