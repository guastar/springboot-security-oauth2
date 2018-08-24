package com.lxg.springboot.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * @Description:
 */
@Entity
@Table(name = "role")
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Role implements Serializable {
    private static final long serialVersionUID = 8604990093149376515L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Getter(onMethod = @_({@Id,@Column(name="id",nullable=false),@GeneratedValue(strategy = GenerationType.AUTO)}))
    @Setter
    private int id;

    @Getter(onMethod = @_(@Column(name="role_name")))
    @Setter
    private String role_name;

    // @Accessors
    /**
     * @Accessors 主要用于控制生成的getter和setter
     * 主要参数介绍
     *
     *     fluent boolean值，默认为false。此字段主要为控制生成的getter和setter方法前面是否带get/set
     *     chain boolean值，默认false。如果设置为true，setter返回的是此对象，方便链式调用方法
     *     prefix 设置前缀 例如：@Accessors(prefix = "abc") private String abcAge 当生成get/set方法时，会把此前缀去掉
     *
     */

    // @Getter and @Setter
    /**
     * 可以用@Getter / @Setter注释任何字段（当然也可以注释到类上的），让lombok自动生成默认的getter / setter方法。
     * 默认生成的方法是public的，如果要修改方法修饰符可以设置AccessLevel的值，例如：@Getter(access = AccessLevel.PROTECTED)
     */

    // @NoArgsConstructor, @RequiredArgsConstructor, @AllArgsConstructor
    /**
     * @NoArgsConstructor生成一个无参构造方法。当类中有final字段没有被初始化时，
     * 编译器会报错，此时可用@NoArgsConstructor(force = true)，然后就会为没有
     * 初始化的final字段设置默认值 0 / false / null。对于具有约束的字段（例如@NonNull字段），
     * 不会生成检查或分配，因此请注意，正确初始化这些字段之前，这些约束无效。
     *
     * @RequiredArgsConstructor会生成构造方法（可能带参数也可能不带参数），
     * 如果带参数，这参数只能是以final修饰的未经初始化的字段，或者是以@NonNull注解的未经初始化的字段
     * @RequiredArgsConstructor(staticName = "of")会生成一个of()的静态方法，并把构造方法设置为私有的
     *
     * @AllArgsConstructor 生成一个全参数的构造方法
     */

    // @ToString
    /**
     * 生成toString()方法，默认情况下，它会按顺序（以逗号分隔）打印你的类名称以及每个字段。
     * 可以这样设置不包含哪些字段@ToString(exclude = "id") / @ToString(exclude = {"id","name"})
     * 如果继承的有父类的话，可以设置callSuper 让其调用父类的toString()方法，例如：@ToString(callSuper = true)
     */

    // @EqualsAndHashCode
    /**
     * 生成hashCode()和equals()方法，默认情况下，它将使用所有非静态，非transient字段。但可以通过在可选的exclude参数中来排除更多字段。
     * 或者，通过在parameter参数中命名它们来准确指定希望使用哪些字段。
     */

    // @Data
    /**
     * @Data 包含了 @ToString、@EqualsAndHashCode、@Getter / @Setter和@RequiredArgsConstructor的功能
     */

    // @Synchronized    给方法加上同步锁

    // @Wither      提供了给final字段赋值的一种方法

    // @onX         在注解里面添加注解的方式
}
