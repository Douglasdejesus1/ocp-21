package chapter13;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentClollectionsClass {
    public static void main(String[] args) {
        var foodData = new ConcurrentHashMap<String, Integer>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for (String key : foodData.
                keySet())
            foodData.remove(key);
    }
}

class SynchoronizedCollectionsClass {
    // 1. Uso pessoal (calculadora)
    HashMap<String, Double> historico = new HashMap<>();
    static class Session{}
    // 2. Serviço com poucas operações (login/logout)
    Map<String, Session> sessoes =
            Collections.synchronizedMap(new HashMap<>());
    static class User{}
    // 3. Cache/Base de dados com muitos acessos
    ConcurrentHashMap<String, User> usuarios =
            new ConcurrentHashMap<>();

    // synchronizedMap é suficiente aqui!
    private Map<String, String> sessoesSync =
            Collections.synchronizedMap(new HashMap<>());

    // Cada operação é simples e isolada
    public void criarSessao(String userId, String token) {
        sessoesSync.put(userId, token); // ✅ Uma operação simples
    }

    public String obterToken(String userId) {
        return sessoesSync.get(userId); // ✅ Uma operação simples
    }

    public void removerSessao(String userId) {
        sessoesSync.remove(userId); // ✅ Uma operação simples
    }

    public static void main(String[] args) throws InterruptedException {
        SynchoronizedCollectionsClass gerenciador =
                new SynchoronizedCollectionsClass();

        // Múltiplas threads fazendo login
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            final int id = i;
            threads[i] = new Thread(() -> {
                // Cada thread faz UMA operação por vez
                gerenciador.criarSessao("user-" + id, "token-" + id);
                System.out.println("✅ Sessão criada para user-" + id);

                String token = gerenciador.obterToken("user-" + id);
                System.out.println("   Token: " + token);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

                gerenciador.removerSessao("user-" + id);
                System.out.println("   Sessão removida");
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("\nTotal de sessões: " +
                gerenciador.sessoes.size());

    }
}