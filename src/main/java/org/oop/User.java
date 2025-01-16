package org.oop;

import java.util.Objects;

/**
 Нарушение:
 Принцип DRY нарушен, так как поля класса объявляются вручную, а затем повторно используются в конструкторах.
 Это может привести к дублированию кода, если в будущем понадобится добавить новые поля или изменить логику инициализации.

 Рекомендация:
 Используйте инструменты вроде Lombok (@Data, @AllArgsConstructor, @NoArgsConstructor), чтобы автоматически
 генерировать геттеры, сеттеры, конструкторы и методы toString(), equals() и hashCode(). Это сократит объем кода и уменьшит вероятность ошибок.
 */
public class User {
    public int id;
    public String username;
    public String password;
    public String email;
    public Role role;

    /**
     Нарушение:
     Принцип DRY нарушен, так как конструкторы дублируют инициализацию полей. Это может привести к ошибкам, если в будущем понадобится изменить логику инициализации.

     Рекомендация:
     Используйте вызов одного конструктора из другого с помощью this(...), чтобы избежать дублирования кода.

     Например:
     public User(int id, String username, String password, String email, Role role) {
     this.id = id;
     this.username = username;
     this.password = password;
     this.email = email;
     this.role = role;
     }
     public User(String username, String password, String email, Role role) {
     this(0, username, password, email, role); // Используем первый конструктор
     }
     */

    public User(int id, String username, String password, String email, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    /**
     Нарушение:
     Принцип KISS нарушен, так как конструктор принимает слишком много параметров.
     Это делает код сложным для использования и поддержки.

     Рекомендация:
     Рассмотрите возможность использования паттерна Builder для упрощения создания объектов.
     */
    public User(String username, String password, String email, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    /**
     Нарушение:
     Принцип YAGNI нарушен, так как методы equals и hashCode могут быть избыточными,
     если в текущей реализации сравнение объектов по id не требуется.

     Рекомендация:
     Убедитесь, что методы equals и hashCode действительно необходимы. Если они не используются, их можно удалить,
     чтобы упростить код.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     Нарушение:
     Принцип KISS нарушен, так как метод toString() реализован с использованием сложного форматирования. Это делает код менее читаемым и усложняет его поддержку.

     Рекомендация:
     Упростите метод toString(), чтобы он возвращал базовое представление объекта.

     Например:

     @Override
     public String toString() {
     return "User{" +
     "id=" + id +
     ", username='" + username + '\'' +
     ", email='" + email + '\'' +
     ", role=" + role +
     '}';
     }
     */
    @Override
    public String toString() {
        return String.format("| %-10d | %-20s | %-30s | %-10s |",
                id, username, email, role.toString());
    }
}