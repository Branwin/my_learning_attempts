import 'package:flutter/material.dart';

class CollectionsPage extends StatelessWidget {
  const CollectionsPage({super.key});

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: ListView(
        padding: const EdgeInsets.all(20),
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text('我的收藏', style: Theme.of(context).textTheme.headlineSmall),
              IconButton(
                onPressed: () {},
                icon: const Icon(Icons.add),
                tooltip: '新建集合',
              ),
            ],
          ),
          const SizedBox(height: 6),
          const Text('按集合整理你的知识卡片。'),
          const SizedBox(height: 24),
          const _CollectionTile(
            title: '计算机基础',
            count: 12,
            icon: Icons.code,
          ),
          const SizedBox(height: 8),
          const _CollectionTile(
            title: '英语阅读',
            count: 8,
            icon: Icons.translate,
          ),
          const SizedBox(height: 8),
          const _CollectionTile(
            title: '待整理',
            count: 3,
            icon: Icons.inbox_outlined,
          ),
        ],
      ),
    );
  }
}

class _CollectionTile extends StatelessWidget {
  const _CollectionTile({
    required this.title,
    required this.count,
    required this.icon,
  });

  final String title;
  final int count;
  final IconData icon;

  @override
  Widget build(BuildContext context) {
    return Card(
      child: ListTile(
        leading: CircleAvatar(
          backgroundColor: Theme.of(context).colorScheme.tertiaryContainer,
          child: Icon(icon),
        ),
        title: Text(title),
        subtitle: Text('$count 个知识点'),
        trailing: const Icon(Icons.chevron_right),
      ),
    );
  }
}
