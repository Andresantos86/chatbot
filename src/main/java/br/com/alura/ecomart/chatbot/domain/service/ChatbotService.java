package br.com.alura.ecomart.chatbot.domain.service;

import br.com.alura.ecomart.chatbot.infra.openai.DadosRequisicaoChatCompletion;
import br.com.alura.ecomart.chatbot.infra.openai.OpenAIClient;
import com.theokanning.openai.completion.chat.ChatCompletionChunk;
import io.reactivex.Flowable;
import org.springframework.stereotype.Service;

@Service
public class ChatbotService {
  private OpenAIClient client;

  public ChatbotService(OpenAIClient client) {
    this.client = client;
  }

  public Flowable<ChatCompletionChunk> responderPergunta(String pergunta){
    var promptSistema = "Você e um chatbot de atendimento" +
            " ao cliente de um ecommerce e deve responder somente perguntas relacionadas com o ecommerce";
    var dados = new DadosRequisicaoChatCompletion(promptSistema, pergunta);
    return  client.enviarRequisicaoChatCompletion(dados);
  }
}
