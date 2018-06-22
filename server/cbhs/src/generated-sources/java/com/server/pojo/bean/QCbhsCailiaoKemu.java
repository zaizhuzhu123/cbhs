package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsCailiaoKemu is a Querydsl query type for CbhsCailiaoKemu
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsCailiaoKemu extends EntityPathBase<CbhsCailiaoKemu> {

    private static final long serialVersionUID = -1755846660L;

    public static final QCbhsCailiaoKemu cbhsCailiaoKemu = new QCbhsCailiaoKemu("cbhsCailiaoKemu");

    public final BooleanPath isRy = createBoolean("isRy");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final BooleanPath status = createBoolean("status");

    public QCbhsCailiaoKemu(String variable) {
        super(CbhsCailiaoKemu.class, forVariable(variable));
    }

    public QCbhsCailiaoKemu(Path<? extends CbhsCailiaoKemu> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsCailiaoKemu(PathMetadata metadata) {
        super(CbhsCailiaoKemu.class, metadata);
    }

}

