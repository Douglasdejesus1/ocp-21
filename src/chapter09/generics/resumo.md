# RESUMO RÁPIDO MELHORADO:

| Contexto | `<T>` | Exemplo `<T>` | `<?>` | Exemplo `<?>` |
|----------|---|-------|-------|-------|
| **Declaração de classe** | ✅ | `class Box<T> { }` | ❌ | `class Box<?> { }` |
| **Declaração de método** | ✅ | `static <T> T get(T t) { }` | ❌ | `static <?> void method() { }` |
| **Instanciação** | ✅ | `Box<String> box = new Box<>();` | ✅ | `Box<?> box = new Box<>();` |
| **Variáveis** | ✅ | `List<String> list = new ArrayList<>();` | ✅ | `List<?> list = new ArrayList<>();` |
| **Upper bounds** | ✅ | `<T extends Number> void process(T t)` | ✅ | `void process(List<? extends Number> list)` |
| **Lower bounds** | ❌ | `<T super Number> void method(T t)` | ✅ | `void add(List<? super Integer> list)` |
| **Casting** | ✅ | `(List<String>) raw` | ✅ | `(List<?>) new ArrayList<String>()` |
| **Lambdas** | ✅ | `Function<String, Integer> f = s -> s.length()` | ✅ | `Consumer<?> c = System.out::println` |
| **Method References** | ✅ | `list.forEach(String::toUpperCase)` | ✅ | `items.forEach(System.out::println)` |
| **Records** | ✅ | `record Box<T>(T content) { }` | ✅ | `Box<?> box = new Box<>("test")` |
| **Pattern Matching** | ✅ | `if (obj instanceof List<String> list)` | ✅ | `if (obj instanceof List<?> list)` |
| **Virtual Threads** | ✅ | `List<String> results = new ArrayList<>()` | ✅ | `List<?> items = new ArrayList<>()` |