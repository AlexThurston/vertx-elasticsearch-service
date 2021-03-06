/*
* Copyright 2014 Red Hat, Inc.
*
* Red Hat licenses this file to you under the Apache License, version 2.0
* (the "License"); you may not use this file except in compliance with the
* License. You may obtain a copy of the License at:
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
* WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
* License for the specific language governing permissions and limitations
* under the License.
*/

package com.englishtown.vertx.elasticsearch;

import com.englishtown.vertx.elasticsearch.ElasticSearchService;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.Vertx;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import java.util.ArrayList;import java.util.HashSet;import java.util.List;import java.util.Map;import java.util.Set;import io.vertx.serviceproxy.ProxyHelper;
import java.util.List;
import com.englishtown.vertx.elasticsearch.ElasticSearchService;
import com.englishtown.vertx.elasticsearch.SearchOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/*
  Generated Proxy code - DO NOT EDIT
  @author Roger the Robot
*/
public class ElasticSearchServiceVertxEBProxy implements ElasticSearchService {

  private Vertx _vertx;
  private String _address;
  private boolean closed;

  public ElasticSearchServiceVertxEBProxy(Vertx vertx, String address) {
    this._vertx = vertx;
    this._address = address;
  }

  public void start() {
  }

  public void stop() {
  }

  public void index(String index, String type, String id, JsonObject source, Handler<AsyncResult<JsonObject>> resultHandler) {
    checkClosed();
    JsonObject _json = new JsonObject();
    _json.put("index", index);
    _json.put("type", type);
    _json.put("id", id);
    _json.put("source", source);
    DeliveryOptions _deliveryOptions = new DeliveryOptions();
    _deliveryOptions.addHeader("action", "index");
    _vertx.eventBus().<JsonObject>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        resultHandler.handle(Future.failedFuture(res.cause()));
      } else {
        resultHandler.handle(Future.succeededFuture(res.result().body()));
      }
    });
  }

  public void get(String index, String type, String id, Handler<AsyncResult<JsonObject>> resultHandler) {
    checkClosed();
    JsonObject _json = new JsonObject();
    _json.put("index", index);
    _json.put("type", type);
    _json.put("id", id);
    DeliveryOptions _deliveryOptions = new DeliveryOptions();
    _deliveryOptions.addHeader("action", "get");
    _vertx.eventBus().<JsonObject>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        resultHandler.handle(Future.failedFuture(res.cause()));
      } else {
        resultHandler.handle(Future.succeededFuture(res.result().body()));
      }
    });
  }

  public void search(List<String> indices, SearchOptions options, Handler<AsyncResult<JsonObject>> resultHandler) {
    checkClosed();
    JsonObject _json = new JsonObject();
    _json.put("indices", new JsonArray(indices));
    _json.put("options", options.toJson());
    DeliveryOptions _deliveryOptions = new DeliveryOptions();
    _deliveryOptions.addHeader("action", "search");
    _vertx.eventBus().<JsonObject>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        resultHandler.handle(Future.failedFuture(res.cause()));
      } else {
        resultHandler.handle(Future.succeededFuture(res.result().body()));
      }
    });
  }

  public void scroll(String scrollId, String scroll, Handler<AsyncResult<JsonObject>> resultHandler) {
    checkClosed();
    JsonObject _json = new JsonObject();
    _json.put("scrollId", scrollId);
    _json.put("scroll", scroll);
    DeliveryOptions _deliveryOptions = new DeliveryOptions();
    _deliveryOptions.addHeader("action", "scroll");
    _vertx.eventBus().<JsonObject>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        resultHandler.handle(Future.failedFuture(res.cause()));
      } else {
        resultHandler.handle(Future.succeededFuture(res.result().body()));
      }
    });
  }

  public void delete(String index, String type, String id, Handler<AsyncResult<JsonObject>> resultHandler) {
    checkClosed();
    JsonObject _json = new JsonObject();
    _json.put("index", index);
    _json.put("type", type);
    _json.put("id", id);
    DeliveryOptions _deliveryOptions = new DeliveryOptions();
    _deliveryOptions.addHeader("action", "delete");
    _vertx.eventBus().<JsonObject>send(_address, _json, _deliveryOptions, res -> {
      if (res.failed()) {
        resultHandler.handle(Future.failedFuture(res.cause()));
      } else {
        resultHandler.handle(Future.succeededFuture(res.result().body()));
      }
    });
  }


  private List<Character> convertToListChar(JsonArray arr) {
    List<Character> list = new ArrayList<>();
    for (Object obj: arr) {
      Integer jobj = (Integer)obj;
      list.add((char)jobj.intValue());
    }
    return list;
  }

  private Set<Character> convertToSetChar(JsonArray arr) {
    Set<Character> set = new HashSet<>();
    for (Object obj: arr) {
      Integer jobj = (Integer)obj;
      set.add((char)jobj.intValue());
    }
    return set;
  }

  private void checkClosed() {
    if (closed) {
      throw new IllegalStateException("Proxy is closed");
    }
  }
  private <T> Map<String, T> convertMap(Map map) {
    return (Map<String, T>)map;
  }
  private <T> List<T> convertList(List list) {
    return (List<T>)list;
  }
  private <T> Set<T> convertSet(List list) {
    return new HashSet<T>((List<T>)list);
  }
}