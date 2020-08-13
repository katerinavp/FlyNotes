package com.example.a8androidpetukhova_diploma.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.a8androidpetukhova_diploma.ItemData;
import com.example.a8androidpetukhova_diploma.R;
import java.util.ArrayList;
import java.util.List;

public class ItemsDataAdapter extends BaseAdapter {

    // Хранит список всех элементов списка
    private List<ItemData> items;

    // LayoutInflater – класс, который из
    // layout-файла создает View-элемент.
    private LayoutInflater inflater;

     // Конструктор, в который передается контекст
    // для создания контролов из XML. И первоначальный список элементов.
//     @Inject
     public ItemsDataAdapter(Context context, List<ItemData> items) {
        if (items == null) {
            this.items = new ArrayList<>(); //если данные пустые , то создаем новый список
        } else {
            this.items = items;
        }
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // для инфлейта наших данных используем инфлейтер
    }

    // Добавляет элемент в конец списка.
    // notifyDataSetChanged сообщает об обновлении данных и переотрисовывает.
    // Вы можете как угодно менять items в других местах.
    // Но не забывайте вызывать notifyDataSetChanged чтобы все обновилось.
    public void addItem(ItemData item) {
        this.items.add(item); // добавляем новый датакласс
        notifyDataSetChanged();
    }

    public void setItems(List<ItemData> items) {
        this.items = items;
    }

    // Удаляет элемент списка.
    public void removeItem(int position) {
        items.remove(position);
        notifyDataSetChanged();
    }

    // Обязательный метод абстрактного класса BaseAdapter.
    // Он возвращает колличество элементов списка.
    @Override
    public int getCount() {
        return items.size(); //передаем длину нашего списка, допуситм у нас список из 10 элементов
    }

    // Тоже обязательный метод.
    // Должен возвращать элемент списка на позиции - position
    @Override
    public ItemData getItem(int position) { // передается позиция и надо возвратить нашу дату по позиции.
        if (position < items.size()) {
            return items.get(position);
        } else {
            return null;
        }
    }

    // И это тоже обязательный метод.
    // Возвращает идентификатор. Обычно это position.
    @Override
    public long getItemId(int position) {
        return position;
    }

    // Самый интересный обязательный метод.
    // Создает или возвращает переиспользуемый View, с новыми данными
    // для конкретной позиции. BaseAdapter – хитрый класс,
    // он не держит в памяти все View - это дорого и будет тормозить.
    // Поэтому он рисует только то что видно. Для этого есть convertView.
    // Если нет чего переиспользовать, то создается новый View.
    // А потом напоняет старую или новую View нужными данными.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.item_notes, parent, false);
        }

        ItemData itemData = items.get(position);

        TextView infoTxtTitle = view.findViewById(R.id.infoTxtTitle);
        TextView infoTxtNote = view.findViewById(R.id.infoTxtNote);
        TextView infoTxtDeadline = view.findViewById(R.id.infoTxtDeadline);

        infoTxtTitle.setText(itemData.getTitle());
        infoTxtNote.setText(itemData.getNote());
        infoTxtDeadline.setText(itemData.getDeadline()); // один листенер для всех чебоксов

        return view;
    }
}
