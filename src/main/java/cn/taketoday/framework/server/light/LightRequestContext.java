/*
 * Original Author -> 杨海健 (taketoday@foxmail.com) https://taketoday.cn
 * Copyright © TODAY & 2017 - 2021 All Rights Reserved.
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see [http://www.gnu.org/licenses/]
 */

package cn.taketoday.framework.server.light;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpCookie;
import java.util.Map;

import cn.taketoday.context.utils.MultiValueMap;
import cn.taketoday.web.RequestContext;
import cn.taketoday.web.http.HttpHeaders;
import cn.taketoday.web.multipart.MultipartFile;

/**
 * @author TODAY 2021/4/13 11:35
 */
public class LightRequestContext extends RequestContext {

  // request
  final LightRequest request;

  public LightRequestContext(LightRequest request) {
    this.request = request;
  }

  @Override
  protected String doGetRequestURI() {
//    return request.getBaseURL();

    return null;
  }

  @Override public String getRequestURL() {
    return null;
  }

  @Override public String getQueryString() {
    return null;
  }

  @Override protected String doGetQueryString() {
    return null;
  }

  @Override protected HttpCookie[] doGetCookies() {
    return new HttpCookie[0];
  }

  @Override public void addCookie(HttpCookie cookie) {

  }

  @Override protected Map<String, String[]> doGetParameters() {
    return null;
  }

  @Override protected String doGetMethod() {
    return null;
  }

  @Override public String remoteAddress() {
    return null;
  }

  @Override public long getContentLength() {
    return 0;
  }

  @Override protected InputStream doGetInputStream() throws IOException {
    return null;
  }

  @Override protected MultiValueMap<String, MultipartFile> parseMultipartFiles() {
    return null;
  }

  @Override public String getContentType() {
    return null;
  }

  @Override protected HttpHeaders createRequestHeaders() {
    return null;
  }

  @Override public void setContentLength(long length) {

  }

  @Override public boolean committed() {
    return false;
  }

  @Override public void sendRedirect(String location) throws IOException {

  }

  @Override public void setStatus(int sc) {

  }

  @Override public void setStatus(int status, String message) {

  }

  @Override public int getStatus() {
    return 0;
  }

  @Override public void sendError(int sc) throws IOException {

  }

  @Override
  public void sendError(int sc, String msg) throws IOException {

  }

  @Override
  protected OutputStream doGetOutputStream() throws IOException {
    return null;
  }



  @Override public <T> T nativeRequest() {
    return null;
  }

  @Override public <T> T nativeRequest(Class<T> requestClass) {
    return null;
  }

  @Override public <T> T nativeResponse() {
    return null;
  }

  @Override public <T> T nativeResponse(Class<T> responseClass) {
    return null;
  }

  @Override
  public String toString() {
    return "Light HTTP: " + super.toString();
  }
}