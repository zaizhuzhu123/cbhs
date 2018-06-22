package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsProject is a Querydsl query type for CbhsProject
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsProject extends EntityPathBase<CbhsProject> {

    private static final long serialVersionUID = 1743322813L;

    public static final QCbhsProject cbhsProject = new QCbhsProject("cbhsProject");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> startUpDate = createNumber("startUpDate", Long.class);

    public final NumberPath<Integer> state = createNumber("state", Integer.class);

    public final BooleanPath status = createBoolean("status");

    public QCbhsProject(String variable) {
        super(CbhsProject.class, forVariable(variable));
    }

    public QCbhsProject(Path<? extends CbhsProject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsProject(PathMetadata metadata) {
        super(CbhsProject.class, metadata);
    }

}

