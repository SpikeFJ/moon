package com.gdw;

import java.util.*;

/**
 * 数据项集合
 *
 * @author spike
 */
public class ProtocolItemCollection extends ProtocolItem implements List<ProtocolItem> {

    private ArrayList<ProtocolItem> protocolItems = new ArrayList<ProtocolItem>();

    @Override
    public int decode(byte[] data, int offset) {
        return 0;
    }

    @Override
    public byte[] encode() {
        byte[] tmp = new byte[0];
        for (ProtocolItem protocolItem : protocolItems) {
            byte[] encode = protocolItem.encode();
        }
        return new byte[0];
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<ProtocolItem> iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public boolean add(ProtocolItem protocolItem) {
        return false;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends ProtocolItem> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends ProtocolItem> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public ProtocolItem get(int index) {
        return null;
    }

    public ProtocolItem set(int index, ProtocolItem element) {
        return null;
    }

    public void add(int index, ProtocolItem element) {

    }

    public ProtocolItem remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<ProtocolItem> listIterator() {
        return null;
    }

    public ListIterator<ProtocolItem> listIterator(int index) {
        return null;
    }

    public List<ProtocolItem> subList(int fromIndex, int toIndex) {
        return null;
    }
}
